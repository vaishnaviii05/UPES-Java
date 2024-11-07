class staticouter 
{
    int outer_x=10;
    static int outer_y=20;
    static int outer_z=30;

    static class staticnestedclass
    {
        
        void display()
        {
            staticouter out = new staticouter();
            System.out.println("Outer x:"+ out.outer_x);
            System.out.println("Outer y:"+ outer_y);
            System.out.println("Outer z:"+ outer_z);
        }
    }
    




    public static void main (String [] args)
    {
        staticouter.staticnestedclass obj = new staticouter.staticnestedclass();
        obj.display();
    }
}

