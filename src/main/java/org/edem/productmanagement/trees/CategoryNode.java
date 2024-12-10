package org.edem.productmanagement.trees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.edem.productmanagement.entities.Category;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryNode {
    private Category category;
    private CategoryNode left;
    private CategoryNode right;

    public CategoryNode(Category category) {
        this.category = category;
    }
}