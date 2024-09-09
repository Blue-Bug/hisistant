import { defineStore } from 'pinia'

export const useCartStore = defineStore('cart', {
    state: () => ({
        open: false,
    }),
    actions: {
        toggleCart() {
            this.open = !this.open
            console.log(this.open);
        },
        openCart() {
            this.open = true
        },
        closeCart() {
            this.open = false
        }
    }
})
