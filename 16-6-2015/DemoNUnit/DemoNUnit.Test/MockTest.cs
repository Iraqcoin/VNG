using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Moq;
using NUnit.Framework;
using DemoNUnit;

namespace DemoNUnit.Test
{
    [TestFixture]
    class MockTest
    {
        [Test]
        public void AddAAATest()
        {
            // Arrange
            Mock<ISecondDeep> secondDeep = new Mock<ISecondDeep>();
            secondDeep.Setup(x => x.SomethingToDo(It.IsAny<string>())).Returns(true);
            // Act
            FirstDeep fd = new FirstDeep(secondDeep.Object);
            // Assert
            Assert.That(fd.AddA("ABD"), Is.EqualTo("ABCAAA"));
        }
    }
}
