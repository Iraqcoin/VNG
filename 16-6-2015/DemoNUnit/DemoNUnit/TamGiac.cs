using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoNUnit
{
    public class TamGiac
    {
        public double Canh1, Canh2, Canh3;

        public TamGiac(double canh1, double canh2, double canh3)
        {
            Canh1 = canh1;
            Canh2 = canh2;
            Canh3 = canh3;
        }

        public enum LoaiTamGiac {
            Thuong,
            Can,
            Deu,
            Vuong,
            KhongPhaiTamGiac
        }

        public LoaiTamGiac PhanLoaiTamGiac()
        {
            if ((Canh1 == Canh2) || (Canh1 == Canh3))
                return LoaiTamGiac.Can;

            if ((Canh1 == Canh2) && (Canh1 == Canh3))
                return LoaiTamGiac.Deu;

            if (Canh1 * Canh1 + Canh2 * Canh2 == Canh3 * Canh3)
                return LoaiTamGiac.Vuong;

            return LoaiTamGiac.KhongPhaiTamGiac;
        }

        
    }
}
