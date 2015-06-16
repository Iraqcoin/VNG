using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoNUnit
{
    public class FirstDeep
    {
        private ISecondDeep oa;

        public FirstDeep(ISecondDeep oa)
        {
            this.oa = oa;
        }

        public string AddA(string str)
        {
            return String.Concat(str, oa.SomethingToDo(str) ? "AAA" : "BBB");
        }
    }

    public interface ISecondDeep
    {
        bool SomethingToDo(string str);
    }

}
