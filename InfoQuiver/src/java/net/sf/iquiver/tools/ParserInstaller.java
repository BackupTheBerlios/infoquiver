/*********************************************************************
 * ParserInstaller.java
 * created on 18.07.2004 by netseeker
 * $Source: /home/xubuntu/berlios_backup/github/tmp-cvs/infoquiver/Repository/InfoQuiver/src/java/net/sf/iquiver/tools/ParserInstaller.java,v $
 * $Date: 2004/07/18 15:55:38 $
 * $Revision: 1.1 $
 *********************************************************************/

package net.sf.iquiver.tools;

import java.util.List;

import net.sf.iquiver.om.ContentParser;
import net.sf.iquiver.om.ContentParserPeer;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.torque.Torque;
import org.apache.torque.util.Criteria;

/**
 * Simple tool for adding new parser implementations to InfoQuiver
 * @author netseeker aka Michael Manske
 */
public class ParserInstaller
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

            if (line.hasOption( "fTorque" ) && line.hasOption("class") && args.length == 5)
            {
                try
                {
                    Torque.init( line.getOptionValue( "fTorque" ) );
                    String clazz = line.getOptionValue("class");                    
                    String name = args[4];
                    
                    ContentParser cParser = null;
                    Criteria crit = new Criteria();
                    crit.add( ContentParserPeer.CONTENT_PARSER_IMPLEMENTATION, clazz );
                    List cParsers = ContentParserPeer.doSelect( crit );

                    if (cParsers != null && !cParsers.isEmpty())
                    {
                        System.out.println( "Existing parser found, install failed." );
                        System.exit( 1 );
                    }
                    else
                    {
                        cParser = new ContentParser();
                        cParser.setContentParserImplementation( clazz );
                        cParser.setContentParserName( name );
                    }

                    cParser.save();

                    System.out.println( "Parser " + clazz + " installed successfully" );
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
        formatter.printHelp( "java net.sf.iquiver.tools.ParserInstaller [...] name", options );
    }

    private static void createOptions()
    {
        options = new Options();
        options.addOption( "help", false, "print this message" );
        options.addOption( "fTorque", true,
                "specifies the path to the configuration file with settings for the persistence layer" );
        options.addOption( "class", true, "specifies the java class which contains the parser implementation");
    }

}