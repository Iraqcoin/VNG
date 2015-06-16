using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoNUnit
{
    public class MayTinh
    {
        public int Cong(int x, int y)
        {
            var tong = x + y;
            return tong;
        }

        public double Chia(int x, int y)
        {
            return (x / y);
        }
    }
}
