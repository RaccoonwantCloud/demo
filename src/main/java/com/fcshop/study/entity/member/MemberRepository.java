package com.fcshop.study.entity.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    String UPDATE_MEMBER = "UPDATE carrotsMember " +
                            "SET NAME = :#{ShoppingRequestDto.name}, " +
                            "PASSWORD = :#{ShoppingRequestDto.password}, " +
                            "WHERE ID = :#{ShoppingRequestDto.id}";
   // @Query("select mbrNo,id,name,password from Member m where id = :id and password = :password")
   // Member findByMember(@Param("id") String id,@Param("password") String password);

    Member findByIdAndPassword(String id, String password);
//
//    @Query("insert  into Member values (id = :id, name = :name,password = :password)")
//    void insertMember(@Param("id") String id,@Param("name") String name,@Param("password") String password);



//    @Transactional
//    @Modifying
//    @Query(value = UPDATE_MEMBER, nativeQuery = true)
//    public int updateMember(@Param("ShoppingRequestDto")ShoppingRequestDto shoppingRequestDto);

}
