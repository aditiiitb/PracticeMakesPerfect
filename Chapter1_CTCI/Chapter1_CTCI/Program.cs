using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Chapter1_CTCI.Algos;

namespace Chapter1_CTCI
{
    class Program
    {
        public static void Main(string[] args)
        {
            string s = "aabbcccdee";
            Debug.WriteLine(s);
            //StringAlgos.Reverse(ref s);
            StringAlgos.RemoveDupes(ref s);
            Debug.WriteLine(s);
        }

    }
}
