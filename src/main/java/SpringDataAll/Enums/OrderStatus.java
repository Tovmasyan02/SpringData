package SpringDataAll.Enums;

import SpringDataAll.Entitys.Order;

public enum OrderStatus {

    ACCEPTED(1),
    INPROGRESS(2),
    COMPLETED(3);

    private final Integer statusWeight;

    OrderStatus(Integer statusWeight)
    {
        this.statusWeight=statusWeight;
    }

    public Integer getStatusWeight()
    {
        return this.statusWeight;
    }


}
