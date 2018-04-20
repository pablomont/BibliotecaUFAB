
@Configuration
public class MockInjectionConfiguration {
	
	@Bean
	public ItemDao itemDao() {
		ItemDao mockDao = Mockito.mock(ItemDaoImpl.class); 				
	
		return mockDao;
	}
}