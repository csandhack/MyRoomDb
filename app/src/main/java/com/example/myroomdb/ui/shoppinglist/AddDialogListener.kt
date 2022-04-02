package com.example.myroomdb.ui.shoppinglist

import com.example.myroomdb.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}