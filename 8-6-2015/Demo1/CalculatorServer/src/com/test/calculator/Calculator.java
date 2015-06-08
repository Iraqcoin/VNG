package com.test.calculator;

import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.AbstractNonblockingServer.AbstractNonblockingServerArgs;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class Calculator implements CalculatorService.Iface {
	public int add(int a, int b) {
		System.out.println(String.format("add called with %d and %d", a, b));
		return a + b;
	}

	public int sub(int a, int b) {
		System.out.println(String.format("sub called with %d and %d", a, b));
		return a - b;
	}

	public int div(int a, int b) {
		System.out.println(String.format("div called with %d and %d", a, b));
		return a / b;
	}

	public int mult(int a, int b) {
		System.out.println(String.format("mult called with %d and %d", a, b));
		return a * b;
	}

	public static void main(String[] args) {
		try {
			Calculator calc = new Calculator();
			TNonblockingServerTransport serverTransport = new TNonblockingServerSocket(9888);
			CalculatorService.Processor processor = new CalculatorService.Processor(calc);
		
			TServer server = new TNonblockingServer(new TNonblockingServer.Args(serverTransport).
					processor(processor));

			System.out.println("Started service successfully...");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}
