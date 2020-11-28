package com.springdataCassandraNativeCompare.controller;


import com.springdataCassandraNativeCompare.springData.SpringDataRepository;
import com.springdataCassandraNativeCompare.springData.entity.DummyItem;
import com.springdataCassandraNativeCompare.cassandraNative.CassandraNativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Fatih Yıldızlı
 */

@RestController
public class CompareController {

    @Autowired
    SpringDataRepository springDataRepository;

    @Autowired
    CassandraNativeRepository cassandraNativeRepository;


    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/select/springdata", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> selectSpringData() {
        Long startTime = System.currentTimeMillis();
        List<DummyItem> response = springDataRepository.selectAll();
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/select/cassandraNative", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> selectCassandraNative() {
        Long startTime = System.currentTimeMillis();
        List<DummyItem> response = cassandraNativeRepository.selectAll();
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/insert/springdata/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> insertSpringData(@PathVariable("count") int count) {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            springDataRepository.insert(i, "yıldızlı", "fatih");
            System.out.println("spring data insert id:" + i);
        }
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/insert/cassandraNative/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> insertCassandraNative(@PathVariable("count") int count) {

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            cassandraNativeRepository.insertAll(i);
            System.out.println("cassandra native insert id:" + i);
        }
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }


    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/update/springdata/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> updateSpringData(@PathVariable("count") long count) {

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            springDataRepository.update(i, "FYildizli", "fatih");
            System.out.println("spring data update id:" + i);
        }
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/update/cassandraNative/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> updateCassandraNative(@PathVariable("count") long count) {

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            cassandraNativeRepository.updateAll(i);
            System.out.println("cassandra native update id:" + i);
        }
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/delete/springdata/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> deleteSpringData(@PathVariable("count") long count) {

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            springDataRepository.delete(i);
            System.out.println("spring data delete id:" + i);
        }
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/delete/cassandraNative/{count}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> deleteCassandraNative(@PathVariable("count") long count) {

        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            cassandraNativeRepository.deleteAll(i);
            System.out.println("cassandra native delete id:" + i);
        }
        long finishTime = System.currentTimeMillis();
        return new ResponseEntity<>("Elapsed:" + (finishTime - startTime) + "ms",
                HttpStatus.OK);
    }

}
