package chapter12;

public class Entity {

	public String entityName;

	public Entity[] children = new Entity[0];

	public Entity parent;

	public Entity(String entityName) {
		this.entityName = entityName;

	}

	public Entity(String entityName, Entity[] children) {
		this.entityName = entityName;
		this.children = children;
		for (int i = 0; i < children.length; i++) {
			children[i].parent = this;
		}
	}

	public static Entity[] node() {
		return new Entity[] {
				new Entity("中国", new Entity[] {

						new Entity("北京", new Entity[] { new Entity("清华大学"),
								new Entity("北京大学") }),
						new Entity("上海", new Entity[] { new Entity("复旦大学"),
								new Entity("上海交大") }),
						new Entity("天津", new Entity[] { new Entity("南开大学"),
								new Entity("天津大学") }) }),

				new Entity("美国",
						new Entity[] {
								new Entity("马萨诸塞州", new Entity[] {
										new Entity("哈佛大学"),
										new Entity("麻省理工学院") }),
								new Entity("康涅狄格州", new Entity[] { new Entity(
										"耶鲁大学") }),
								new Entity("新泽西州", new Entity[] { new Entity(
										"普林斯顿大学") }) }),

				new Entity("英国",
						new Entity[] {
								new Entity("牛津市", new Entity[] { new Entity(
										"牛津大学") }),
								new Entity("剑桥市", new Entity[] { new Entity(
										"剑桥大学") }) }) };
	}

}
