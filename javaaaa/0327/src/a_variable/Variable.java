package a_variable;

public class Variable {
	
	int a; // ��������

	public static void main(String[] args) {
		
		/*
		 * << ���� >>
		 * - �ϳ��� �����͸� ������ �� �ִ� �޸𸮻��� ����
		 * - Ÿ��(�������� ����)�� ������(������ �̸�)���� ������ ���� �� �ִ�.
		 * 
		 * << ��� ������ �⺻�� ������>>
		 * - ����: byte(1byte), short(2byte), int(4byte), long(8byte)
		 * - �Ǽ�: float(4byte), double(8byte)
		 * - ����: char(2byte)
		 * - ��: boolean(1byte)
		 * 
		 * << ��� ��Ģ>>
		 * - �� �ȿ��� �������� �ߺ��� �� ����.
		 * - ���� ��ҹ���, �ѱ�, ����, Ư������('_', '$') �� ����� �� �ִ�. (* �ѱ� ����� ����)
		 * - ��ҹ��ڰ� ���еǸ� ���̿� ������ �ִ�.
		 * - ���ڷ� ������ �� ����.
		 * - ������ ����� �� ����.
		 * - [�⺻������ ������ �ҹ��ڸ� ����ϰ�, ����� �빮�ڸ� ����Ѵ�.]
		 * - [���� �ܾ�� �̷���� ��쿡�� �ܾ��� ù ���ڸ� �빮�ڷ� �Ѵ�.(����� ����ٷ� ����)]
		 * - [Ŭ�������� ù���ڴ� �빮�ڷ� �Ѵ�.]
		 * - [��Ű������ ��� �ҹ��ڷ� �Ѵ�.]
		 */
		byte _byte;
		short _short;
		int _int;
		long _long;
		float _float;
		double _double;
		char _char;
		boolean _boolean;
		
		_byte = 10;
		_short = 20;
		_int = 30;
		_long = 40L;
		_float = 3.14f;
		_double = 3.14d;    // double�� ���̻縦 ������ �� �ִ�.
		_char = '��';        // char Ÿ���� ���ڴ� '' ���� ������ �͸� �����ϴ�. "" �� ��Ʈ��
		_boolean = true;
		
		System.out.println(_byte);
		System.out.println(_short);
		System.out.println(_int);
		System.out.println(_long);
		System.out.println(_float);
		System.out.println(_double);
		System.out.println(_char);
		System.out.println(_boolean);
	}

}
