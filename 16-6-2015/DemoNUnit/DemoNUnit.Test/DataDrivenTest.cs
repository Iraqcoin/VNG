using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using NUnit.Framework;
using System.Text.RegularExpressions;
using ExcelDataDrivenTests;
using System.Collections;
using System.Data;

// http://www.tomdupont.net/2014/06/nunit-testcase-data-driven-unit-test.html

namespace DemoNUnit.Test
{
    [TestFixture]
    class DataDrivenTest
    {
        // Here is a simple example that is the equivalent of an
        // inline data attribute from xUnit.

        [TestCase(1, 2, 3)]
        [TestCase(2, 3, 5)]
        public void SimpleSumCase(int a, int b, int expected)
        {
            var actual = a + b;
            Assert.AreEqual(expected, actual);
        }

        // Here is an ugly example of how to expect a OverflowException

        [TestCase(Int32.MaxValue, 1)]
        public void SimpleSumFailCase(int a, int b)
        {
            Assert.Throws<OverflowException>(() =>
            {
                checked
                {
                    var actual = a + b;
                }
            });
        }

        // Now, let's combine the two examples above into one really nice
        // example using both the ExpectedResult and ExpectedException
        // properties. THIS IS THE KIND OF TEST YOU WANT TO WRITE!

        [TestCase(1, 2, ExpectedResult = 3)]
        [TestCase(2, 3, ExpectedResult = 5)]
        [TestCase(Int32.MaxValue, 1, ExpectedException = typeof(OverflowException))]
        public int ReturnSumCase(int a, int b)
        {
            checked
            {
                return a + b;
            }
        }

        // Here is a simple example of using a TestCaseSource, simila to an
        // xUnit property data attribute.

        private static readonly object[] SimpleSumCases =
        {
            new object[] {1, 2, 3},
            new object[] {2, 3, 5}
        };

        [TestCaseSource("SimpleSumCases")]
        public void SimpleSumCaseSource(int a, int b, int expected)
        {
            var actual = a + b;
            Assert.AreEqual(expected, actual);
        }

        // And here is the equivalent of the our awesome new ReturnSumCase
        // method above but using a TestCaseSource.

        private static readonly object[] ReturnSumCases =
        {
            new TestCaseData(1, 2).Returns(3),
            new TestCaseData(2, 3).Returns(5),
            new TestCaseData(Int32.MaxValue, 1).Throws(typeof(OverflowException))
        };

        [TestCaseSource("ReturnSumCases")]
        public int ReturnSumCaseSource(int a, int b)
        {
            checked
            {
                return a + b;
            }
        }

        // Here are two really cool new NUnit features called Combinatorial and
        // Sequential tests. To be honest I am having a hard time thinking of a
        // good use for these, but they are both very cool!

        // NOTE: This test will run SIX times, once for each permutation of 
        // specified arguments.

        [Test, Combinatorial]
        public void Combinatorial([Values(1, 2, 3)] int x, [Values("A", "B")] string s)
        {
            var concact = x + s;
            var isMatch = Regex.IsMatch(concact, "[0-9][A-Z]?");
            Assert.IsTrue(isMatch);
        }

        // NOTE: This test will run THREE times, as the arguments will sequentially
        // be enumerated and passed in. The third call will be 3 and null.

        [Test, Sequential]
        public void Sequential([Values(1, 2, 3)] int x, [Values("A", "B")] string s)
        {
            var concact = x + s;
            var isMatch = Regex.IsMatch(concact, "[0-9][A-Z]?");
            Assert.IsTrue(isMatch);
        }

        [Test]
        [TestCaseSource("SampleTestCaseData")]
        public void TestFromExcel(IDictionary<string, object> testData)
        {
            var expected = testData.Keys.Count;
            var actual = testData.Values.Count;
            Assert.AreEqual(expected, actual);

        }

        public static IEnumerable<TestCaseData> SampleTestCaseData
        {
            get
            {
                string excelFile = @"c:\Demo\DemoNUnit\Testcases\testcases-sample.xls";
                string sheetName = "Sheet1";

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

                        // Test Name
                        var testName = string.Format("TC{0}",rowNum);

                        return new TestCaseData(testDataArgs).SetName(testName);
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
