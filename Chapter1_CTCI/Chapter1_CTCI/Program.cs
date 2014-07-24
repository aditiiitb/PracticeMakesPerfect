using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter1_CTCI
{
    class Program
    {
        public static void Main(string[] args)
        {
            string s = "abcde";
            Debug.WriteLine(s);
            Debug.WriteLine(Reverse(s));
        }

        public static string Reverse(string s)
        {
            int n = s.Length;
            for (int i = 0; i < n/2; i++)
            {
                s = Swap(s.ToCharArray(), i, n - 1);
            }
            return s;
        }

        public static string Swap(char[] s, int i, int j)
        {
            if (i < s.Length && i > 0 && j < s.Length && j > 0)
            {
                char a = s[i];
                s[i] = s[j];
                s[j] = a;
            }
            return s.ToString();
        }
    }
}
