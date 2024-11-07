class outerclass
{
  int x=20;
  class nestedclass
  {
    int y=30;
    public void nestedinfo()
    {
      System.out.println(x+" "+y);
    }
  }
  public void outerinfo()
  {
    nestedclass nest= new nestedclass();
    nest.nestedinfo();
    System.out.println(x+" "+ nest.y);
  }


  public static void main (String [] args)
  {
    outerclass out= new outerclass();
    out.outerinfo();
  }
}