- Mybatis Batch: 1万 ：2m6s10ms

```
public void batchInsert(List<MemberInfo> listData) {
    SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
    MemberInfoMapper sqlStatement = sqlSession.getMapper(MemberInfoMapper.class);
    for (MemberInfo listDatum : listData) {
        sqlStatement.insert(listDatum);
    }
    sqlSession.commit();
    sqlSession.close();
}
```
- Mybatis Batch: 100万 
```
未测试/// - -！！
```
- JDBC 1万：4s

```
public void batchInsertByJDBC(List<MemberInfo> listData) throws SQLException {
    String sql = "insert into t_member_info(user_code,user_nick_name,phone,deleted,activity,add_time,last_login_time)\n" +
            " values(?,?,?,?,?,?,?)";
    Connection connection = dataSource.getConnection();
    connection.setAutoCommit(false);
    PreparedStatement prest = connection.prepareStatement(sql,
            ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
    for (MemberInfo memberInfo : listData) {
        prest.setString(1, memberInfo.getUserCode());
        prest.setString(2, memberInfo.getUserNickname());
        prest.setString(3, memberInfo.getPhone());
        prest.setBoolean(4, memberInfo.isDeleted());
        prest.setBoolean(5, memberInfo.isActivity());
        prest.setLong(6, memberInfo.getAddTime().getTime());
        prest.setLong(7, memberInfo.getLastLoginTime().getTime());
        prest.addBatch();
    }

    prest.executeBatch();
    connection.commit();
    connection.close();
}
```
- JDBC 100万：3m40s10ms

```
public void batchInsertByJDBC(List<MemberInfo> listData) throws SQLException {
    String sql = "insert into t_member_info(user_code,user_nick_name,phone,deleted,activity,add_time,last_login_time)\n" +
            " values(?,?,?,?,?,?,?)";
    Connection connection = dataSource.getConnection();
    connection.setAutoCommit(false);
    PreparedStatement prest = connection.prepareStatement(sql,
            ResultSet.TYPE_SCROLL_SENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
    for (MemberInfo memberInfo : listData) {
        prest.setString(1, memberInfo.getUserCode());
        prest.setString(2, memberInfo.getUserNickname());
        prest.setString(3, memberInfo.getPhone());
        prest.setBoolean(4, memberInfo.isDeleted());
        prest.setBoolean(5, memberInfo.isActivity());
        prest.setLong(6, memberInfo.getAddTime().getTime());
        prest.setLong(7, memberInfo.getLastLoginTime().getTime());
        prest.addBatch();
    }

    prest.executeBatch();
    connection.commit();
    connection.close();
}
```

### 