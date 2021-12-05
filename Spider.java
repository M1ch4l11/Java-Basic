public class Spider {
    private int rows = 1,colums = 1;
    private int x = 1,y = 1;
    private char z;

    public Spider(int rows,int colums,int x,int y,char z){
        if(rows < 5) this.rows = 10;
        else if(rows >= 5) this.rows = rows;
        if(colums < 5) this.colums = colums;
        else if(colums >=5) this.colums = colums;
        if(y < rows || y >= rows )this.y = 3;
        else this.y = y;
        if(x < colums || x >= colums)this.x = 2;
        else this.x = x;
        this.z = z;
    }

    public void setValues(int rows,int colums,int x,int y,char z){
        if(rows < 5) this.rows = 10;
        else if(rows >= 5) this.rows = rows;
        if(colums < 5) this.colums = colums;
        else if(colums >=5) this.colums = colums;
        if(y < rows || y >= rows )this.y = 3;
        else this.y = y;
        if(x < colums || x >= colums)this.x = 2;
        else this.x = x;
        this.z = z;
    }

    public String up(){
        if(this.x==1)return "Au!";
        this.x++;
        return "OK";
    }

    public String down(){
        if(this.x==rows-1)return "Au!";
        this.x++;
        return "OK";
    }
    public String left(){
        if(this.y==1) return "Au!";
        this.y--;
        return "OK";
    }
    public String right(){
        if(this.y==colums-1) return "Au!";
        this.y++;
        return "OK";
    }

    public String getInfo(){
        String prvyPosledny = "";
        String vnutorneRiadky = "";
        for (int i = 0; i < colums; i++) {
            prvyPosledny += "x";
        }
        for (int i = 2; i < colums; i++) {
            vnutorneRiadky += " ";
        }
        vnutorneRiadky =  "x" + vnutorneRiadky + "x";
        String out = "";
        for (int i = 0; i < rows; i++) {
            if(i==0)out+= prvyPosledny + "\n";
            else if(i==rows-1)out+=prvyPosledny;
            else {
                if(x==i) {
                    out+= vnutorneRiadky.substring(0,x) + z + vnutorneRiadky.substring(x+1) + "\n";
                    continue;
                    }
                out+= vnutorneRiadky + "\n";
            }
        }
       
        return out;

    }

    public String geSpider(){
        return "[" + x + "," + y + "]";
    }

    public String getDimensions(){return this.rows + " x " + this.colums;}

}
