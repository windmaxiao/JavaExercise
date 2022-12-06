package com.example.demo.HelloWorld.DbTest.dao;

import com.example.demo.HelloWorld.DbTest.entity.User1;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 注解的mybatis
 * @author maxiao
 */
@Mapper
public interface User1Dao {

    /**
     * 通过name查user
     * @param name name
     * @return user1
     */
    @Select("SELECT * FROM user1 WHERE name = #{name}")
    User1 findUserByName(@Param("name") String name);

    /**
     * 查全表
     * @return 所有user
     */
    @Select("SELECT * FROM user1 WHERE 1=1")
    List<User1> getAllUser();

    /**
     * 插入
     * @param id id
     * @param name name
     * @param sex sex
     * @param age age
     * @param money money
     */
    @Insert("INSERT INTO user1(id, name, sex, age, money) VALUE(#{id}, #{name},#{sex},#{age},#{money})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    void insertUser(@Param("id")int id, @Param("name")String name, @Param("sex")String sex, @Param("age")Integer age, @Param("money")BigDecimal money);


    /**
     * 更新
     * @param name name
     * @param sex sex
     * @param age age
     * @param money money
     * @param id id
     */
    @Update("UPDATE user1 SET name = #{name}, sex = #{sex}, age = #{age}, money = #{money}")
    void updateUser(@Param("name")String name, @Param("sex")String sex, @Param("age")Integer age, @Param("money")BigDecimal money, @Param("id")Integer id);

    /**
     * 删除
     * @param id id
     */
    @Delete("DELETE FROM user1 where id = #{id}")
    void deleteUser(@Param("id") Integer id);

}
