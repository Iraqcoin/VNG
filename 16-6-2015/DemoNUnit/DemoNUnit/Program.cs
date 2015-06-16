using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace DemoNUnit
{
    class Program
    {
        static void Main(string[] args)
        {
            TamGiac ABC = new TamGiac(3, 4, 5);
            TamGiac.LoaiTamGiac loai = ABC.PhanLoaiTamGiac();
            switch (loai)
            {
                case TamGiac.LoaiTamGiac.Can:
                    Console.WriteLine("Tam giac Can");
                    break;
                case TamGiac.LoaiTamGiac.Deu:
                    Console.WriteLine("Tam giac Deu");
                    break;
                case TamGiac.LoaiTamGiac.Vuong:
                    Console.WriteLine("Tam giac Vuong");
                    break;
                case TamGiac.LoaiTamGiac.Thuong:
                    Console.WriteLine("Tam giac Thuong");
                    break;
                case TamGiac.LoaiTamGiac.KhongPhaiTamGiac:
                    Console.WriteLine("Khong phai tam giac");
                    break;
            }
        }
    }
}
