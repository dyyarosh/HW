package by.dy.rdc.bean;
import by.dy.rdc.bean.*;


public class Item {

    private int Id;
    private int OwnerId;
    private String Name;
    private double Price;
    private Status Status;

    public int getId() {
        return Id;
    }

    public void setId(int _id) {
        this.Id = _id;
    }

    public int getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(int _ownerId) {
        this.OwnerId = _ownerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String _name) {
        this.Name = _name;
    }


    public double getPrice() {
        return Price;
    }

    public void setPrice(double _price) {
        this.Price = _price;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status _status) {
        this.Status = _status;
    }



    public Item(int _id, int _ownerId, String _name, double _price, Status _status) {

        setId (_id);
        setOwnerId(_ownerId);
        setName(_name);
        setPrice(_price);
        setStatus(_status);

    }
    public Item () {

    }

    @Override
    public String toString() {
        return "Item [Id=" + this.getId() + ", OwnerId=" + this.getOwnerId() +", name=" + this.getName() + ", price=" + getPrice() +  "]";
    }
}

