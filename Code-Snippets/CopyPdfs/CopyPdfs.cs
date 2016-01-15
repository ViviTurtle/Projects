using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using System.IO;
using System.Xml;
using System.Collections;
using System.Threading;
using System.Configuration;

namespace CopyPDFs
{
    class CopyPDFs
    {
        
        static ArrayList failedFiles = new ArrayList();
        static int totalFails = 0;
        static string consoleLogPath;

        public static void Main(string[] args)
        {
            //--------------test code---------------
            //string sourcePath = @"C:\Users\tester\Documents\test_dir";
            //string destPath = @"C:\Users\tester\Documents\test_dir\test_dest";
            //fileCopy("test.pdf", sourcePath, destPath);
            //fileCreate("created.pdf", destPath);
            //--------------------------------------
            string file;
            //Parameters
            string dtPDF_Type1 = "Your SQL Procedure that gets certain File names that you want copied 100%";
            string dtPDF_Type2 = "Your SQL Procedure that gets certain File names that you want copied, but not viewable";
            //Set up in Web.config
            string sourcePath = ConfigurationManager.AppSettings["SourcePath"].ToString();
            string destPath = ConfigurationManager.AppSettings["DestinationPath"].ToString();
            string YourSQLDB = ConfigurationManager.ConnectionStrings["YourSQLDB"].ToString(); //change as setting
            string logfileDirectory = ConfigurationManager.AppSettings["LogfileDirectory"].ToString();
            string logName = ConfigurationManager.AppSettings["LogfileName"].ToString();

            try
            {
                //Creates a LogFile and Stores the path
                consoleLogPath = logfileDirectory + @"\" + logName;
                fileCreate(logName, destPath);
                //Checks if source Folder Exist, else exists
                if (!System.IO.Directory.Exists(sourcePath))
                {
                    writeConsoleAndLog("Source Folder does not exist");
                    writeConsoleAndLog("Exiting Application");
                    writeConsoleAndLog("A Log has been created at: " + consoleLogPath);
                    writeConsoleAndLog("Press any key to continue");
                    Console.ReadKey();
                    System.Environment.Exit(1);
                }

                //Creates Dummy _Type2 PDFs based of SQL query
                DataTable dt_Type2 = getSQLData(dtPDF_Type2, YourSQLDB);
                foreach (DataRow row in dt_Type2.Rows)
                {
                    file = row["pdf_filename"].ToString();
                    fileCreate(file, destPath);
                }
                //Copies _Type1 PDFS
                DataTable dt_Type1 = getSQLData(dtPDF_Type1, YourSQLDB);
                foreach (DataRow row in dt_Type1.Rows)
                {
                    file = row["pdf_filename"].ToString();
                    fileCopy(file, sourcePath, destPath);
                }
                //Prints all the files with errors
                writeConsoleAndLog("The following files have failed be created/copied:");
                foreach (string fail in failedFiles)
                {
                    writeConsoleAndLog(fail);
                }
                // Keep console window open in debug mode.
                writeConsoleAndLog("Creating Indexed PDF's are Done");
                writeConsoleAndLog("A Log has been created at: " + consoleLogPath);
                writeConsoleAndLog("Press any key to continue");
                Console.ReadKey();
            }
            catch (Exception ex)
            {
                writeConsoleAndLog(ex.Message);
                writeConsoleAndLog("Exiting Application");
                writeConsoleAndLog("A Log has been created at:" + consoleLogPath);
                writeConsoleAndLog("Press any key to continue");
                Console.ReadKey();
                System.Environment.Exit(1);
            }


        }

        /*
         * Appends a text to console and adds it to a LogFile
         * @param text the text to write in the console and LogFile
         */
        public static void writeConsoleAndLog(string text)
        {

            Console.WriteLine(text);
            try
            {
                //Make sure path has been declared first
                using (System.IO.StreamWriter file = new System.IO.StreamWriter(consoleLogPath, true))
                {
                    file.WriteLine(text);
                }
            }
            //Possible to be in use by another application
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                //Exists if fails 1000 times
                if (++totalFails > 1000)
                {
                    Console.WriteLine("Exiting Application");
                    Console.WriteLine("Press any key to continue");
                    Console.ReadKey();
                    System.Environment.Exit(1);
                }
                //Retries
                Console.WriteLine("Failed to Log into Logfile. Retrying...");
                //Wait 5 seconds
                System.Threading.Thread.Sleep(5000);
                Console.WriteLine(text);


            }
        }
        /*
         * Returns a DataTable based on a QueryString and a connectionString
         * @param queryString the queryString to do
         * @param connectionString the connectionString to use
         * @returns the DataTable associated with the query
         */
        public static DataTable getSQLData(string queryString, string connectionString)
        {
            SqlConnection sqlConnection1 = new SqlConnection(connectionString);
            sqlConnection1.Open();
            SqlCommand cmd = new SqlCommand();
            cmd.CommandText = queryString;
            cmd.CommandType = CommandType.Text;
            cmd.Connection = sqlConnection1;
            DataTable dt = new DataTable();
            try
            {
                dt.Load(cmd.ExecuteReader());
            }
            catch (Exception ex)
            {
                //If SQL query doesnt work just exit
                writeConsoleAndLog(ex.ToString());
                writeConsoleAndLog("Exiting Application");
                writeConsoleAndLog("A Log has been created at:");
                writeConsoleAndLog("Press any key to continue");
                Console.ReadKey();
                System.Environment.Exit(1);
            }
            sqlConnection1.Close();
            return dt;
        }

        /*
         * Copies a file from a certain directory, to another, if it exists it overwrites
         * @param fileName the file to copy
         * @param sourcePath the folder to copy from
         * @param targetPath the folder to copy to
         */
        public static void fileCopy(string fileName, string sourcePath, string targetPath)
        {

            // Use Path class to manipulate file and directory paths.
            string sourceFile = System.IO.Path.Combine(sourcePath, fileName);
            string destFile = System.IO.Path.Combine(targetPath, fileName);
            try
            {
                writeConsoleAndLog(String.Format("Attempting to copy: {0,34}", fileName));
                // To copy a folder's contents to a new location:
                // Create a new target folder, if necessary.
                if (!System.IO.Directory.Exists(targetPath))
                {
                    System.IO.Directory.CreateDirectory(targetPath);
                }

                // To copy a file to another location and 
                // overwrite the destination file if it already exists
                System.IO.File.Copy(sourceFile, destFile, true);
                writeConsoleAndLog(String.Format("Copy Successful: {0,37}", fileName));
            }
            catch (FileNotFoundException fnf)
            {
                writeConsoleAndLog(String.Format("File not found: {0,38}", fileName));
                failedFiles.Add(fileName);

            }
            catch (Exception ex)
            {
                writeConsoleAndLog(ex.Message);
                if (++totalFails > 1000)
                {
                    writeConsoleAndLog("Reached max limit of fails: Exiting Application");
                    writeConsoleAndLog("Press any key to continue");
                    Console.ReadKey();
                    System.Environment.Exit(1);
                }
                //Possible for Network to be down wait 5 seoncds and try again
                writeConsoleAndLog("IO Error. Retrying...");
                System.Threading.Thread.Sleep(5000);
                fileCopy(fileName, sourceFile, targetPath);
            }


        }
        /*
         * Creates a file with the string "Hello" to target folder
         * @param the file it should be named
         * @param targetPath the folder it should be created in
         */
        public static void fileCreate(string file, string targetPath)
        {

            string path = targetPath + "\\" + file;
            if (!System.IO.Directory.Exists(targetPath))
            {
                System.IO.Directory.CreateDirectory(targetPath);
            }
            else
            {
                writeConsoleAndLog(String.Format("Attempting to create: {0,32}", file));
            }
            try
            {
                // Create the file.
                using (FileStream fs = File.Create(path))
                {
                    Byte[] info = new UTF8Encoding(true).GetBytes("");
                    // Add some information to the file.
                    fs.Write(info, 0, info.Length);
                }
                writeConsoleAndLog(String.Format("Create Successful: {0,35}", file));
            }
            catch (Exception ex)
            {
                writeConsoleAndLog(ex.ToString());
                failedFiles.Add(file);
            }
        }
    }
}
