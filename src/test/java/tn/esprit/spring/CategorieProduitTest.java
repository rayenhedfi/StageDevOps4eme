package tn.esprit.spring;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;


import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.repositories.CategorieProduitRepository;
import tn.esprit.spring.services.CategorieProduitServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CategorieProduitTest {
	
	
	@Mock
	CategorieProduitRepository CategorieProduitRepo;
	@InjectMocks
	CategorieProduitServiceImpl CategorieProduitServ;
	
	CategorieProduit c1 = new CategorieProduit(1l, "f1","l1", null);
	List<CategorieProduit> listcateg = new ArrayList<CategorieProduit>(){
		{
		add(new CategorieProduit(2,"f2", "l2",null));
		add(new CategorieProduit(3,"f3", "l3", null));
		}

};

@Test
public void testRetrieveCat() {
Mockito.when(CategorieProduitRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(c1));
CategorieProduit cat1 = CategorieProduitServ.retrieveCategorieProduit(1l);
Assertions.assertNotNull(cat1);
}
}
