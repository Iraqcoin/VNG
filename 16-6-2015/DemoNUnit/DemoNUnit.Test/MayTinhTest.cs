using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using ExcelDataDrivenTests;
using System.Data;

namespace DemoNUnit.Test
{
    [TestFixture]    
    class MayTinhTest
    {
        [Test]
        public void KiemTraCong()
        {
            int x = 1, y = 2;
            MayTinh m = new MayTinh();
            int actual = m.Cong(x, y);
            int expected = 3;
            Assert.AreEqual(expected, actual);
        }

        [Test]
        public void KiemTraChia0()
        {
            MayTinh m = new MayTinh();
            Assert.Throws<DivideByZeroException>(() =>
            {
                checked
                {
                    var actual = m.Chia(1, 0);
                }
            });
        }

        [Test]
        [TestCaseSource("SampleTestCaseData")]
        public void KiemTraChiaTuFileExcel(IDictionary<string, object> testData)
        {
            int x, y;
            x = Int32.Parse(testData["X"].ToString());
            y = Int32.Parse(testData["Y"].ToString());

            MayTinh m = new MayTinh();
            if (testData["Expected"].ToString() == "DivideByZeroException")
            {
                Assert.Throws<DivideByZeroException>(() =>
                {
                    checked
                    {
                        var actual = m.Chia(x, y);
                    }
                });
            }
            else
            {
                double actual = m.Chia(x, y);
                double expected = double.Parse(testData["Expected"].ToString());
                Assert.AreEqual(expected, actual);
            }

        }

        public static IEnumerable<TestCaseData> SampleTestCaseData
        {
            get
            {
                string excelFile = @"c:\Demo\DemoNUnit\Testcases\testcases-tamgiac.xlsx";
                string sheetName = "Sheet2";
                string category = "KiemTraChiaTuFileExcel";

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
