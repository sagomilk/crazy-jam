using System;
using System.Collections.Generic;

using System.Text;
using System.Security.Cryptography;

namespace ConsoleApplication
{
    /// <summary>
    ///  KeyCodeUtil 
    ///  计算工具类
    ///  linhuanyuan
    /// </summary>
    class KeyCodeUtil
    {
        public static string Key = "1313LJJMTD4XXX";

        public static string CalculateMD5(string input)
        {
            // step 1, calculate MD5 hash from input
            MD5 md5 = System.Security.Cryptography.MD5.Create();
            byte[] inputBytes = System.Text.Encoding.UTF8.GetBytes(input);
            byte[] hash = md5.ComputeHash(inputBytes);

            // step 2, convert byte array to hex string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.Length; i++)
            {
                sb.Append(hash[i].ToString("X2"));
            }
            return sb.ToString().ToUpper();
        }

        public static string CalculateDahongwaKeyCode(SortedDictionary<string, string> parameters)
        {
            // step 1 , append the parameters string (with the format of key join value)
            StringBuilder sb = new StringBuilder();
            foreach (var parameter in parameters)
            {
                sb.Append(parameter.Key);

                sb.Append(parameter.Value);
            }

            // step 2 , append dahongwa key
            sb.Append(Key);

            return CalculateMD5(sb.ToString());
        }

        static void Main(string[] args)
        {

            SortedDictionary<string, string> parameters = new SortedDictionary<string, string>();
            parameters.Add("UniqueID", "OI20150707");
            //parameters.Add("WBID", "WBID1234");
            //parameters.Add("Weight", "3.00");
            parameters.Add("Fee", "12.00");

            // C7A193350597514E39AF58BAF80ED665
            Console.WriteLine("KeyCode:" + CalculateDahongwaKeyCode(parameters));
            Console.Read();
        }
    }
}
