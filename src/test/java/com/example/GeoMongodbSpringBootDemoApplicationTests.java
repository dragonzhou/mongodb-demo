package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GeoMongodbSpringBootDemoApplication.class)
public class GeoMongodbSpringBootDemoApplicationTests {

	@Autowired
	private MongoTemplate template;

	@Autowired
	private GeoLocationDao geoLocationDao;

	@Test
	public void initData() {
		//初始化数据 相差 400公里
		geoLocationDao.save(new GeoLocation("鹤山市",new Point(112.99206,22.740501)));
		geoLocationDao.save(new GeoLocation("桂林市",new Point(110.295787,25.288211)));
	}

	@Test
	public  void doQuery()
	{
		//查询  KILOMETERS
		Point point = new Point(110.295787, 25.288211);
		Criteria criteria = new Criteria();
		Query query = new Query(criteria);
		query.limit(20);
		//NearQuery nq = NearQuery.near(point.getX(),point.getY(), Metrics.KILOMETERS).maxDistance(new Double(200));
		NearQuery nq = NearQuery.near(point.getX(),point.getY(), Metrics.KILOMETERS).maxDistance(new Double(400));
		GeoResults<GeoLocation> empGeoResults = template.geoNear(nq, GeoLocation.class);
		System.out.println("geo 查询");
		if (empGeoResults != null) {
			for (GeoResult<GeoLocation> e : empGeoResults) {
				System.out.println("结果 ================ " + e.getContent().getName());
			}
		}

	}

}
