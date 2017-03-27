package carsonsx;


/**
* carsonsx/HelloHelper.java .
* 由IDL-to-Java 编译器 (可移植), 版本 "3.2"生成
* 从Hello.idl
* 2017年3月27日 星期一 下午05时18分31秒 CST
*/

abstract public class HelloHelper
{
  private static String  _id = "IDL:carsonsx/Hello:1.0";

  public static void insert (org.omg.CORBA.Any a, carsonsx.Hello that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static carsonsx.Hello extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (carsonsx.HelloHelper.id (), "Hello");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static carsonsx.Hello read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HelloStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, carsonsx.Hello value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static carsonsx.Hello narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof carsonsx.Hello)
      return (carsonsx.Hello)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      carsonsx._HelloStub stub = new carsonsx._HelloStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static carsonsx.Hello unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof carsonsx.Hello)
      return (carsonsx.Hello)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      carsonsx._HelloStub stub = new carsonsx._HelloStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
