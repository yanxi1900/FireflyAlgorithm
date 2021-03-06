package edu.hhu.innerac.ffa.entiy.extension;

import java.util.Collections;

import edu.hhu.innerac.ffa.entiy.Firefly;
import edu.hhu.innerac.ffa.entiy.FireflyAlo;
import edu.hhu.innerac.ffa.template.Point;

/**
 * @author innerac
 * 在萤火虫种群中加入淘汰机制，每次移动删除掉亮度最弱的萤火虫，同时最优的萤火虫克隆一份进行随机扰动。
 */
public abstract class FireflyAloSelection extends FireflyAlo {

	public FireflyAloSelection(int i_popNum, int i_dim) {
		super(i_popNum, i_dim);
	}
	
	public FireflyAloSelection(int i_popNum, int i_dim, double i_alpha, double i_beta, double i_gamma) {
		super(i_popNum, i_dim, i_alpha, i_beta, i_gamma);
	}

	@SuppressWarnings("unchecked")
	private void selection(){
		Collections.sort(fireflies);
		Firefly firefly = fireflies.get(0).clone();
		firefly.setMaxAttraction(1.0);
		Point vector = new Point(dim, 0, alpha);
		firefly.setVector(vector);
		fireflies.set(popNum-1, firefly);
	}
	
	@Override
	public void myFuntion(){
		selection();
	}
}
