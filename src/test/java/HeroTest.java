/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void Hero_instantiatesCorrectly_true(){
      Hero myHero=new Hero("batman");
      assertEquals(true, myHero instanceof Hero);
    }
    @Test
    public void Hero_instantiatesWithName_String(){
      Hero myHero =new Hero("batman");
      assertEquals("batman", myHero.getName());
    }
    @Test
    public void Hero_instantiatesWithPower_String(){
      Hero myHero =new Hero("being rich");
      assertEquals("being rich", myHero.getPower());
    }
    @Test
    public void Hero_instantiatesWithWeakness_String(){
      Hero myHero=new Hero("none");
      assertEquals("none",myHero.getWeakness());
    }
    @Test
    public void Hero_returnsAllInstances_true(){
      Hero firstHero=new Hero("batman");
      Hero secondHero=new Hero("superman");
      assertEquals(true,Hero.all().contains(firstHero));
      assertEquals(true,Hero.all().contains(secondHero));
    }
    @Test
    public void clear_emptiesAllHeroesFromArrayList_0(){
      Hero firstHero=new Hero("batman");
      Hero.clear();
      assertEquals(Hero.all().size(),0);
    }
    @Test
    public void  getId_heroesInstantiateWithAnID_1(){
      Hero.clear();//clear the arraylist of objects made by other tests
      Hero firstHero=new Hero("batman");
      assertEquals(1,firstHero.getId());
    }
    @Test
    public void find_returnsHeroWithSameId_secondHero(){
      Hero firstHero=new Hero("batman");
      Hero secondHero=new Hero("superman");
      assertEquals(Hero.find(secondHero.getId()),secondHero);

    }
}
