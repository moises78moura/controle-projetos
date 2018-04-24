package br.com.controle.model;

import java.io.Serializable;

import org.hibernate.proxy.HibernateProxyHelper;

/**
 * Base class for all JPA entities.
 * 
 *
 */
public abstract class BaseEntity<T extends Serializable> {
	
//	private Long id;
	 
//    public abstract Long getId();
//    {
//        return id;
//    }
// 
//    public void setId(Long id) {
//        this.id = id;
//    }
     
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((id == null) ? 0 : id.hashCode());
//        return result;
//    }
// 
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        BaseEntity other = (BaseEntity) obj;
//        if (id == null) {
//            if (other.id != null)
//                return false;
//        } else if (!id.equals(other.id))
//            return false;
//        return true;
//    }
	/**
	 * This method should return the primary key.
	 * 
	 * @return
	 */
	public abstract T getId();
	
	/* As a starting point, we provide a basic mean for entities
	 * to test for equality using their "id".
	 * 
	 * Please note that THIS IS NOT ALWAYS ACCEPTABLE since newly generated
	 * ids might break Set/Collection semantics. Please refer to the documentarion
	 * before doing something like this.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BaseEntity)) {
			return false;
		}
		if (getId() == null || ((BaseEntity<?>) obj).getId() == null) {
			return false;
		}
		if (!getId().equals(((BaseEntity<?>) obj).getId())) {
			return false;
		}
		if (!HibernateProxyHelper.getClassWithoutInitializingProxy(obj)
				.isAssignableFrom(this.getClass())) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return getId() == null ? super.hashCode() : getId().hashCode();
	}

}
