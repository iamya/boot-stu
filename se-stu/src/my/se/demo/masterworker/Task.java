package my.se.demo.masterworker;

public class Task {

   private int id;

   private String name;

   private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Object handle() {

        Object result = null;
        //业务处理操作
        try {
            result = this.getPrice();
            System.out.println(id + " 业务处理操作...");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}
