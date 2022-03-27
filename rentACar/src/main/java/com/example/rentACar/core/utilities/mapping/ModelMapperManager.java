package com.example.rentACar.core.utilities.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperManager implements ModelMapperService{
	
	private ModelMapper modelMapper;/*ModelMapper interfacesini implemente eden yine kendi somut sinifidir.
	ModelMapper interfacesi o somut sinifin referance'sini tutuyor olacak.*/

	/*
	 * Somut Class'i enjekte etmemizin sebebi intance'nin sürekli bir daha bir daha üretilmemesi içindir.
	 * Bu somut class'i new'lemedik bunu nasıl yaparız? -->> Bunun bir tane @Bean'ini olustururuz.
	 */
	
	public ModelMapperManager(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	@Override
	public ModelMapper forDto() {
		/*
		 * setAmbiguityIgnored ne ise yarıyor arastir.
		 * Dto'lar için çalışırken MatchingStrategies kısmını LOOSE(gevsek) yapabiliriz çünkü bütün alanların map'lanmasina gerek yok.
		 */
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		/*
		 * Request'ler için çalışırken MatchingStrategies kısmını STANDARD(standart) yapabiliriz çünkü bütün alanların map'lanmasini istiyoruz.
		 */
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
	}

}
