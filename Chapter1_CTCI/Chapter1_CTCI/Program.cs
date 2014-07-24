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
                s = Swap(s, i, n - 1 - i);
            }
            return s;
        }

        public static string Swap(string st, int i, int j)
        {
            StringBuilder sb = new StringBuilder(st);
            if (i < st.Length && i >= 0 && j < st.Length && j >= 0)
            {
                char a = sb[i];
                sb[i] = sb[j];
                sb[j] = a;
                
            }
            return sb.ToString();
        }
    }
}
