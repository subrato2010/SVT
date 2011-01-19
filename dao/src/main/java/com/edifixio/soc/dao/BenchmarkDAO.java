// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Benchmark;


public interface BenchmarkDAO<T extends Benchmark> {
    public List<T> findall() throws SVTException;
    public T getByName(String name) throws SVTException;
    public T getById(String id) throws SVTException;
    public T getByIdOrLatest(String id) throws SVTException;
    public T addBenchMark(Benchmark benchMark) throws SVTException;
}
