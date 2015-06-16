using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DemoNUnit;
using NUnit.Framework;
using System.Text.RegularExpressions;
using ExcelDataDrivenTests;
using System.Collections;
using System.Data;
using Moq;

namespace DemoNUnit.Test
{
    [TestFixture]
    class TamGiacTest
    {
        [Test]
        public void KiemTraTamGiacDeu()
        {
            TamGiac ABC = new TamGiac(3, 3, 3);
            TamGiac.LoaiTamGiac loai = ABC.PhanLoaiTamGiac();
            Assert.AreEqual(TamGiac.LoaiTamGiac.Deu, loai);
        }

        [Test]
        [TestCaseSource("SampleTestCaseData")]
        public void PhanLoaiTamGiacTestFromExcel(IDictionary<string, object> testData)
        {
            double side1, side2, side3;
            side1 = double.Parse(testData["Side1"].ToString());
            side2 = double.Parse(testData["Side2"].ToString());
            side3 = double.Parse(testData["Side3"].ToString());

            TamGiac ABC = new TamGiac(side1, side2, side3);
            var actual = ABC.PhanLoaiTamGiac();

            TamGiac.LoaiTamGiac expected = TamGiac.LoaiTamGiac.KhongPhaiTamGiac;
            switch (testData["Expected"].ToString())
            {
                case "Can": expected = TamGiac.LoaiTamGiac.Can;
                    break;
                case "Deu": expected = TamGiac.LoaiTamGiac.Deu;
                    break;
                case "Vuong": expected = TamGiac.LoaiTamGiac.Vuong;
                    break;
                case "Thuong": expected = TamGiac.LoaiTamGiac.Thuong;
                    break;
                case "Invalid": expected = TamGiac.LoaiTamGiac.KhongPhaiTamGiac;
                    break;
            }
            
            Assert.AreEqual(expected, actual);

        }

        public static IEnumerable<TestCaseData> SampleTestCaseData
        {
            get
            {
                string excelFile = @"c:\Demo\DemoNUnit\Testcases\testcases-tamgiac.xlsx";
                string sheetName = "Sheet1";
                string category = "TamGiacTestFromExcel";
                
                var testcases = ExcelTestCaseDataReader.New()
                    .FromFileSystem(excelFile)
                    .AddSheet(sheetName)
                    .GetTestCases(delegate(string sheet, DataRow row, int rowNum)
                    {
                        var testDataArgs = new Dictionary<string, object>();

                        foreach (DataColumn column in row.Table.Columns)
                        {
                            testDataArgs[column.ColumnName] = row[column];
                        }

                        var testName = string.Format("TC{0}({1})", testDataArgs["TC"], testDataArgs["Name"]);
                        
                        return new TestCaseData(testDataArgs).SetName(testName).SetCategory(category);
                    }
                 );

                foreach (TestCaseData testCaseData in testcases)
                {
                    yield return testCaseData;
                }
            }
        }
    }
}
