package module03.dao;


import module03.model.Company;

import java.util.List;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public interface CompaniesDAO {
    void addCompany(Company company);

    void readCompany(int id);

    void updateCompany(String name,int id);

    void deleteCompany(int id);

    List<Company> listCompany();
}
