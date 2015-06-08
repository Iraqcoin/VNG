package com.test.calculator;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class Main {
	public static void main(String[] args) {
		try {
			TTransport transport;

			transport = new TFramedTransport(new TSocket("localhost", 9888));
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			CalculatorService.Client client = new CalculatorService.Client(
					protocol);

			System.out.print(client.mult(3, 5));

			transport.close();
		} catch (TException x) {
			x.printStackTrace();
		}
	}
}
