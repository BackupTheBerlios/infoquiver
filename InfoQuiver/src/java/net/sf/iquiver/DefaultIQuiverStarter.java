/*
 * Created on 07.03.2004
 *  
 */
package net.sf.iquiver;

import java.io.File;
import java.io.IOException;

import net.sf.iquiver.configuration.Configuration;
import net.sf.iquiver.configuration.ConfigurationConstants;
import net.sf.iquiver.configuration.impl.DefaultProperiesConfiguration;

import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

/**
 * @author netseeker aka Michael Manske
 */
public class DefaultIQuiverStarter
{
    private static Options options;

    public static void main( String[] args )
    {
        if ( options == null )
        {
            createOptions();
        }

        CommandLineParser parser = new PosixParser();

        try
        {
            // parse the command line arguments
            CommandLine line = parser.parse( options, args);

            if ( line.hasOption( "help") )
            {
                usage();
                System.exit( 1);
            }

            if ( line.hasOption( "version") )
            {
                System.out.println( IQuiver.VERSION);
                System.exit( 1);
            }

            String configDir = null;
            boolean isConfDirOverwritten = false;

            if ( line.hasOption( "c") )
            {
                configDir = line.getOptionValue( "c");
                isConfDirOverwritten = true;
            }
            else
            {
                configDir = ConfigurationConstants.DEFAULT_CONFIG_DIR;
            }

            String cFileMain = null;
            
            if ( line.hasOption( "fIQuiver") )
            {
                cFileMain = line.getOptionValue( "fIQuiver");
            }
            else
            {
                cFileMain = configDir + "/" + ConfigurationConstants.CONFIG_FILE_MAIN;
            }

            Configuration configuration = null;

            try
            {
                configuration = new DefaultProperiesConfiguration( cFileMain );
                if(isConfDirOverwritten) 
                {
                    configuration.addProperty(ConfigurationConstants.OVERWRITE_KEY_CONFIG_DIR, configDir);
                }
            }
            catch ( IOException e )
            {
                System.out.println( "Failed to load configuration from " + cFileMain + " Reason:\n" + e.getMessage());
                System.exit( 1);
            }

            if ( line.hasOption( "fLog") )
            {
                configuration.addProperty( ConfigurationConstants.OVERWRITE_KEY_CONFIG_LOGGER, line
                        .getOptionValue( "fLog"));
            }
            if ( line.hasOption( "fCache") )
            {
                configuration.addProperty( ConfigurationConstants.OVERWRITE_KEY_CONFIG_CACHE, line
                        .getOptionValue( "fCache"));
            }
            if ( line.hasOption( "fTorque") )
            {
                configuration.addProperty( ConfigurationConstants.OVERWRITE_KEY_CONFIG_PERSISTENCE, line
                        .getOptionValue( "fTorque"));
            }

            startIQuiver( configuration);
        }
        catch ( ParseException exp )
        {
            // oops, something went wrong
            System.err.println( "Commandline parsing failed. Reason:\n" + exp.getMessage());
        }
    }

    private static void usage()
    {
        // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "IQuiver", options);
    }

    private static void createOptions()
    {
        options = new Options();
        options.addOption( "help", false, "print this message");
        options.addOption( "c", true, "specifies the directory to look for required configuration files");
        options.addOption( "fIQuiver", true, "specifies the path to iquivers main configuration file");
        options.addOption( "fLog", true,
                "specifies the path to the configuration file with settings for the logging mechanism");
        options.addOption( "fCache", true,
                "specifies the path to the configuration file with settings for the caching mechanism");
        options.addOption( "fTorque", true,
                "specifies the path to the configuration file with settings for the persistence layer");
        options.addOption( "version", false, "display the version");
    }

    private static void startIQuiver( Configuration conf )
    {
        IQuiver iquiver = new IQuiver();
        try
        {
            iquiver.configure(conf);
            iquiver.start();
        }
        catch ( ConfigurationException e )
        {
            System.out.println( "!!!Failed to start IQuiver!!! Reason:\n" + e.getMessage());
            System.exit( 1);
        }
    }
}
