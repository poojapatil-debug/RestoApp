package service;


import model.MenuItem;
import exception.*;

import java.util.*;

public class MenuService {

    private List<MenuItem> menuList = new ArrayList<>();
    private Set<String> categories = new HashSet<>();

    public void addMenuItem(MenuItem item) throws DuplicateEntryException {
        for (MenuItem m : menuList) {
            if (m.getId() == item.getId()) {
                throw new DuplicateEntryException("Menu ID already exists!");
            }
        }
        menuList.add(item);
        categories.add(item.getCategory());
    }

    public List<MenuItem> getAllItems() {
        return menuList;
    }

    public void updateMenuItem(int id, String name, double price, String category)
            throws ResourceNotFoundException {

        for (MenuItem m : menuList) {
            if (m.getId() == id) {
                m.setName(name);
                m.setPrice(price);
                m.setCategory(category);
                return;
            }
        }
        throw new ResourceNotFoundException("Menu item not found!");
    }

    public void deleteMenuItem(int id) throws ResourceNotFoundException {
        boolean removed = menuList.removeIf(m -> m.getId() == id);
        if (!removed) throw new ResourceNotFoundException("Menu item not found!");
    }
}

