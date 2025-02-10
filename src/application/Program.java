package application;

import db.DB;
import db.DbIntegrityException;
import db.dbException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {
    public static void main(String[] args) {


        Department obj = new Department(1, "Books");

        Seller seller = new Seller(obj, 3000.0, new Date(), "pedro@gmail.com.br", "Pedro",  21);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);

    }
}
