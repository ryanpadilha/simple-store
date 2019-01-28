package br.com.peixeurbano.store;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.peixeurbano.store.commons.DealType;
import br.com.peixeurbano.store.exceptions.UniqueConstraintException;
import br.com.peixeurbano.store.model.BuyOption;
import br.com.peixeurbano.store.model.Deal;
import br.com.peixeurbano.store.model.Purchase;
import br.com.peixeurbano.store.service.BuyOptionService;
import br.com.peixeurbano.store.service.DealService;
import br.com.peixeurbano.store.service.PurchaseService;

@DataMongoTest(includeFilters = @ComponentScan.Filter(Service.class))
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class SimpleStoreTests {

	@Autowired
	private DealService service;

	@Autowired
	private BuyOptionService boptService;

	@Autowired
	private PurchaseService purchaseService;

	@Test()
	public void insertDeal() {
		final BuyOption bopt1 = new BuyOption();
		bopt1.setTitle("Tamanho 20cm");
		bopt1.setNormalPrice(89.90);
		bopt1.setPercentageDiscount(0.0);
		bopt1.setSalePrice(89.90);
		bopt1.setQuantityCupom(100L);
		bopt1.setStartDate(new Date());
		bopt1.setEndDate(new Date());

		final BuyOption bopt2 = new BuyOption();
		bopt2.setTitle("Tamanho 24cm");
		bopt2.setNormalPrice(149.90);
		bopt2.setPercentageDiscount(0.0);
		bopt2.setSalePrice(99.90);
		bopt2.setQuantityCupom(100L);
		bopt2.setStartDate(new Date());
		bopt2.setEndDate(new Date());

		final BuyOption bopt3 = new BuyOption();
		bopt3.setTitle("Tamanho 28cm");
		bopt3.setNormalPrice(169.90);
		bopt3.setPercentageDiscount(0.0);
		bopt3.setSalePrice(109.90);
		bopt3.setQuantityCupom(100L);
		bopt3.setStartDate(new Date());
		bopt3.setEndDate(new Date());

		final BuyOption bopt4 = new BuyOption();
		bopt4.setTitle("Kit 3 Frigideiras");
		bopt4.setNormalPrice(249.90);
		bopt4.setPercentageDiscount(0.0);
		bopt4.setSalePrice(249.90);
		bopt4.setQuantityCupom(100L);
		bopt4.setStartDate(new Date());
		bopt4.setEndDate(new Date());

		final Deal deal = new Deal();
		deal.setTitle("");
		deal.setText("");
		deal.setTotalSold(0L);
		deal.setPublishDate(new Date());
		deal.setEndDate(new Date());
		deal.setType(DealType.PRODUCT);
		deal.setUrl("frigideira-ceramica");

		deal.addBuyOption(bopt1);
		deal.addBuyOption(bopt2);
		deal.addBuyOption(bopt3);
		deal.addBuyOption(bopt4);

		try {
			BuyOption persistBopt1 = boptService.persist(bopt1);
			BuyOption persistBopt2 = boptService.persist(bopt2);
			BuyOption persistBopt3 = boptService.persist(bopt3);
			BuyOption persistBopt4 = boptService.persist(bopt4);
			Deal persistDeal = service.persist(deal);

			assertFalse(persistBopt1.getId().toHexString().isEmpty());
			assertFalse(persistBopt2.getId().toHexString().isEmpty());
			assertFalse(persistBopt3.getId().toHexString().isEmpty());
			assertFalse(persistBopt4.getId().toHexString().isEmpty());
			assertFalse(persistDeal.getId().toHexString().isEmpty());

		} catch (UniqueConstraintException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void processPurchase() {
		final BuyOption bopt1 = new BuyOption();
		bopt1.setTitle("Tamanho 20cm");
		bopt1.setNormalPrice(89.90);
		bopt1.setPercentageDiscount(0.0);
		bopt1.setSalePrice(89.90);
		bopt1.setQuantityCupom(100L);
		bopt1.setStartDate(new Date());
		bopt1.setEndDate(new Date());

		final Deal deal = new Deal();
		deal.setTitle("");
		deal.setText("");
		deal.setTotalSold(0L);
		deal.setPublishDate(new Date());
		deal.setEndDate(new Date());
		deal.setType(DealType.PRODUCT);
		deal.setUrl("frigideira-ceramica");

		deal.addBuyOption(bopt1);

		try {
			BuyOption persistBopt1 = boptService.persist(bopt1);
			Deal persistDeal = service.persist(deal);

			assertFalse(persistBopt1.getId().toHexString().isEmpty());
			assertFalse(persistDeal.getId().toHexString().isEmpty());

			final Purchase purchase = new Purchase();
			purchase.setDealId(persistDeal.getId());
			purchase.setBuyOptionId(persistBopt1.getId());
			purchase.setQuantity(10L);

			Purchase persistPurchase = purchaseService.persist(purchase);
			assertFalse(persistPurchase.getId().toHexString().isEmpty());
			assertTrue(persistPurchase.getQuantity() == 10L);

		} catch (UniqueConstraintException e) {
			e.printStackTrace();
		}
	}

}
