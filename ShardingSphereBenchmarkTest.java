package com.sunrisehouse.shardingspherebenchmarktest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Random
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class shardingSphereBenchmarkTest {
    @State(Scope.Benchmark)
    public static class Counter {
        int insertCount = 0;
        public void increaseInsertCount() {
            this.insertCount += 1;
        }
        public int getInsertCount() {
            return this.insertCount;
        }
    }

    @State(Scope.Benchmark)
    public static class ShardingSphereState {
        private DataSource dataSource;

        @Setup
        public void setup() throws SQLException {
            List<Database> dbs = List.of(
            );

	    dataSource = new ShardingSphereDataSourceConfiguration()
                .createDataSource(dbs);
        }
    }

    @State(Scope.Benchmark
    public static class ComparisonState {
        private DataSource dataSource;

        @Setup
        public void setup() thorws SQLException {
            List<Database> dbs = List.of();
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig .setDriverClassName("com.mysql.cj.jdbc.Driver);
            hikariConfig.setJdbcUrl("jdbc:mysql://"  + dbs.get(0).getUrl());
            hikariConfig.setUsername();
            hikariConfig.setPassword();
            dataSource = new HikariDataSource(hikariConfig);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public ResultSet selectAllShardingSphere(ShardingSphereState state) throws SQLEXCEPTION {
        return selectAll(state.dataSource);
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public ResultSet selectAllComparison(ComparisonState state) throws SQLException {
        return selectAll(state.dataSource);
    }


    private ResultSet selectALl(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM table_name");
        ResultSet resultSet = statement.executeQuery();
        connection.commit();
        connection.close();
        statement.close();
        resultSet.close();
        return resultSet;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public ResultSet selectShardingSphere(ShardingSPhereState state) throws SQLException {
        return select(state.dataSource);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public ResultSet selectComparison(ComparisonState state) throws SQLException {
        return select(state.dataSource);
    }

    private ResultSet select(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "SELECt * FROM table_name WHERE member_id = \"11\"");
        ResultSet resultSet = statement.executeQuery();
        conection.commit();
        connection.close();
        statement.close();
        resultSet.close();
        return resultSet;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public int insertShardingSpehre(ShardingSPhereSTate state, Counter counter) throws SQLException {
        counter.increaseInsertCount();
        return insert(state.dataSource);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit
    public int insertComparison(ComparisonState state, Counter counter) throws SQLException {
        counter.increaseInsertCount();
        return insert(state.dataSource);
    }

    private int insert(DataSource dataSource) thorws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO table_name () VALUES ()");
        statement.setString(1, "sdfsfd");
        statement.setString(2, "sdfsdf");
        statement.setString(3, "sfsdf");

        int result = statement.executeUpdate();
        conneciton.commit();
        connection.close();
        statement.close();
        return result;
    }
}
