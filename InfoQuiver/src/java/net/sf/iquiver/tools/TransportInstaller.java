/*
 * Created on 13.07.2004
 */
package net.sf.iquiver.tools;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import net.sf.iquiver.om.Transport;
import net.sf.iquiver.om.TransportAttribute;
import net.sf.iquiver.om.TransportPeer;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.torque.Torque;
import org.apache.torque.util.Criteria;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * @author netseeker aka Michael Manske
 */
public class TransportInstaller
{
    private static Options options;

    public static void main( String[] args )
    {
        createOptions();
        CommandLineParser parser = new BasicParser();

        try
        {
            // parse the command line arguments
            CommandLine line = parser.parse( options, args );

            if (line.hasOption( "help" ))
            {
                usage();
                System.exit( 1 );
            }

            if (line.hasOption( "fTorque" ) && args.length == 3)
            {
                try
                {
                    Torque.init( line.getOptionValue( "fTorque" ) );
                    String clazz = args[2];
                    String name = clazz.substring( clazz.lastIndexOf( "." ) + 1 );
                    Transport transport = null;
                    Criteria crit = new Criteria();
                    crit.add( TransportPeer.TRANSPORT_IMPLEMENTATION, clazz );
                    List transports = TransportPeer.doSelect( crit );

                    if (transports != null && !transports.isEmpty())
                    {
                        System.out.println( "Existing parser found, install failed." );
                        System.exit( 1 );
                    }
                    else
                    {
                        transport = new Transport();
                        transport.setTransportImplementation( clazz );
                    }

                    URL url = Class.forName( clazz ).getResource( name + ".xml" );
                    SAXReader reader = new SAXReader();
                    Document doc = reader.read( url );
                    Node node = doc.selectSingleNode( "//name" );
                    if (node == null)
                    {
                        System.out
                                .println( "!!!Error!!! Mandatory element \"name\" could not be found, install failed." );
                        System.exit( 1 );
                    }
                    String descr = node.getStringValue();
                    transport.setTransportName( descr );

                    node = doc.selectSingleNode( "//type" );
                    if (node == null)
                    {
                        System.out
                                .println( "!!!Error!!!  Mandatory element \"type\" could not be found, install failed." );
                        System.out
                                .println( "The transport type MUST be set to one of the following numeric values: 0=FETCHER,1=DISPATCHER,2=BOTH" );
                        System.exit( 1 );
                    }

                    descr = node.getStringValue();
                    try
                    {
                        byte type = Byte.parseByte( descr );
                        transport.setTransportType( type );
                    }
                    catch ( Exception e )
                    {
                        System.out.println( "!!!Error!!! The element \"type\" contains an invalid value." );
                        System.out
                                .println( "The transport type MUST be set to one of the following numeric values: 0=FETCHER,1=DISPATCHER,2=BOTH" );
                        System.exit( 1 );
                    }

                    Element root = doc.getRootElement();
                    for (Iterator i = root.elementIterator( "attribute" ); i.hasNext();)
                    {
                        Element element = (Element) i.next();
                        TransportAttribute att = new TransportAttribute();
                        String attName = element.attributeValue( "name" );
                        if (attName == null)
                        {
                            System.out
                                    .println( "!!!Error!!! Mandatory attribute \"name\" could not be found, install failed." );
                            System.out.println( element.toString() );
                            System.exit( 1 );
                        }

                        String attType = element.attributeValue( "type" );
                        if (attType == null)
                        {
                            System.out
                                    .println( "!!!Error!!! Mandatory attribute \"name\" could not be found, install failed." );
                            System.out.println( element.toString() );
                            System.exit( 1 );
                        }

                        att.setTransportAttributeName( attName );
                        att.setTransportAttributeType( attType );

                        String attRequired = element.attributeValue( "mandatory" );
                        if (attRequired != null)
                        {
                            att.setIsMandatory( Boolean.valueOf( attRequired ).booleanValue() );
                        }

                        attRequired = element.attributeValue( "partOfAuthentification" );
                        if (attRequired != null)
                        {
                            att.setIsPartOfAuthentification( Boolean.valueOf( attRequired ).booleanValue() );
                        }

                        transport.addTransportAttribute( att );
                    }

                    transport.save();

                    System.out.println( "Transport " + clazz + " installed successfully" );
                }
                catch ( Exception e )
                {
                    System.out.println( "!!!Error!!! Install failed, see exception trace for more details" );
                    e.printStackTrace();
                }
            }
            else
            {
                usage();
            }
        }
        catch ( ParseException exp )
        {
            // oops, something went wrong
            System.err.println( "Commandline parsing failed. Reason:\n" + exp.getMessage() );
        }

    }

    private static void usage()
    {
        // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "java net.sf.iquiver.tools.TransportInstaller [...] transport", options );
    }

    private static void createOptions()
    {
        options = new Options();
        options.addOption( "help", false, "print this message" );
        options.addOption( "fTorque", true,
                "specifies the path to the configuration file with settings for the persistence layer" );
    }

}