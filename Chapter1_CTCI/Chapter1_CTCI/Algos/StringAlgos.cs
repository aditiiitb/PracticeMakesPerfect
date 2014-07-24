using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chapter1_CTCI.Algos
{
    public class StringAlgos
    {
        
        public static void Reverse(ref string s)
        {
            int n = s.Length;
            for (int i = 0; i < n/2; i++)
            {
               Swap(ref s, i, n - 1 - i);
            }
        }

        public static void Swap(ref string st, int i, int j)
        {
            StringBuilder sb = new StringBuilder(st);
            if (i < st.Length && i >= 0 && j < st.Length && j >= 0)
            {
                char a = sb[i];
                sb[i] = sb[j];
                sb[j] = a;
            }
            st = sb.ToString();
        }

        public static void RemoveDupes(ref string s)
        {
            HashSet<char> FoundSet = new HashSet<char>();
            for (int i = 0; i < s.Length; i++)
            {
                char a = s[i];
                if (FoundSet.Contains(s[i]))
                {
                    s= s.Remove(i, 1);
                    i--;
                }
                else
                {
                    FoundSet.Add(a);
                }
            }
        }
    }
}
