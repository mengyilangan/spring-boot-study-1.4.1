package com.renrenche.jqn.jooq.test.dao.impl;

import com.renrenche.jqn.jooq.test.dao.StudentDao;
import com.renrenche.spring.boot.storage.jooq.IJooqConfigMgr;
import com.renrenche.spring.boot.storage.jooq.JooqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.renrenche.jqn.jooq.test.jooq.tables.Student.STUDENT;
import static org.jooq.impl.DSL.*;

/**
 * @author xiachunyi
 * @date 2018/3/30
 */
@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private IJooqConfigMgr configMgr;

    @Override
    public int insert(String name) {
        return insertSql(name);
    }

    private int insertSql(String name) {
        JooqConfig config = configMgr.getDslConfig("default");
        return using(config.getMasterCfg())
                .insertInto(table("student"), field("name"))
                .values(name).execute();

    }

    private int insertPo(String name) {
        JooqConfig config = configMgr.getDslConfig("default");
        return using(config.getMasterCfg())
                .insertInto(STUDENT, STUDENT.NAME)
                .values(name)
                .returning(STUDENT.ID)
                .fetchOne()
                .getId();
    }

    @Override
    public int update(String source, String dest) {
        return updateSql(source, dest);
    }

    private int updatePO(String source, String dest) {
        JooqConfig config = configMgr.getDslConfig("default");
        return using(config.getMasterCfg())
                .update(STUDENT)
                .set(STUDENT.NAME, dest)
                .where(STUDENT.NAME.eq(source))
                .execute();
    }

    private int updateSql(String source, String dest) {
        JooqConfig config = configMgr.getDslConfig("default");
        return using(config.getMasterCfg())
                .update(table("student"))
                .set(field("sname"), dest)
                .where(field("sname").eq(source))
                .execute();
    }
}
