package carsonsx;

/**
* carsonsx/HelloHolder.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Hello.idl
* 2017年3月27日 星期一 下午05时18分31秒 CST
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
