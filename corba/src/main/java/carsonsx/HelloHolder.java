package carsonsx;

/**
* carsonsx/HelloHolder.java .
* ��IDL-to-Java ������ (����ֲ), �汾 "3.2"����
* ��Hello.idl
* 2017��3��27�� ����һ ����05ʱ18��31�� CST
*/

public final class HelloHolder implements org.omg.CORBA.portable.Streamable
{
  public carsonsx.Hello value = null;

  public HelloHolder ()
  {
  }

  public HelloHolder (carsonsx.Hello initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = carsonsx.HelloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    carsonsx.HelloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return carsonsx.HelloHelper.type ();
  }

}
