/*
 * Copyright 2017 Er. Rahul Rathi [ VanGiex.RR@Gmail.Com ].
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.spielplatz.dataSource;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Er. Rahul Rathi [ VanGiex.RR@Gmail.Com ]
 */
@Component
public class User_doa 
{

    private DataSource ds;
    private JdbcTemplate td;
    private String pass;
    private String sql;
    
    public User_doa() 
    {
       
    }
    
    public DataSource getDs() 
    {
        return ds;
    }
    
    @Autowired
    public void setDs(DataSource ds) 
    {
        this.td = new JdbcTemplate(ds);
    }

    public JdbcTemplate getTd() {
        return td;
    }

    public void setTd(JdbcTemplate td) {
        this.td = td;
    }

    public boolean getPass(String u_name,String pass) 
    {
        sql = "Select password from user where u_name = ? ";
        this.pass = td.queryForObject(sql, new Object[] {u_name} , String.class);
        return this.pass.equals(pass);
    }
    
    
    
}
