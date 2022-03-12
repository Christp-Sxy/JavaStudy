import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONReader;
import com.domain.City;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @ClassName MyDemo
 * @Description TODO
 * @Author Christp
 * @Date 2021/12/5 12:25
 * @Version 1.0
 **/

public class MyDemo {
    public static void main(String[] args) throws Exception {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into city values (?,?,?,?)";
        JSONReader reader = new JSONReader(new FileReader("C:\\Users\\sxy\\Desktop\\mydata.txt"));
        reader.startObject();
        while (reader.hasNext()){
            String key = reader.readString();
            if ("resultcode".equals(key)){
                String value = reader.readObject().toString();
                System.out.println("resultcode为:" + value);
            }else if ("reason".equals(key)){
                String value = reader.readObject().toString();
                System.out.println("reason为:" + value);
            }else if ("result".equals(key)){
                reader.startArray();
                while (reader.hasNext()){
                    City city = new City();
                    reader.startObject();
                    while (reader.hasNext()){
                        String singleKey = reader.readString();
                        String value = reader.readObject().toString();
                        if ("id".equals(singleKey)){
                            city.setId(Integer.parseInt(value));
                        }
                        if ("province".equals(singleKey)){
                            city.setProvince(value);
                        }
                        if ("city".equals(singleKey)){
                            city.setCity(value);
                        }
                        if ("district".equals(singleKey)){
                            city.setDistrict(value);
                        }
                    }
                    template.update(sql, city.getId(), city.getProvince(), city.getCity(), city.getDistrict());
                    reader.endObject();
                }
                reader.endArray();
            }else if ("error_code".equals(key)){
                String value = reader.readObject().toString();
                System.out.println("error_code为:" + value);
            }
        }
        reader.endObject();
    }
}
