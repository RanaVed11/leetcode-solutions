class TimeLimitedCache {
    constructor() {
        this.cache = new Map();
    }

    set(key, value, duration) {
        const exists = this.cache.has(key) && this.cache.get(key).expiry > Date.now();
        this.cache.set(key, { value, expiry: Date.now() + duration });
        return exists;
    }

    get(key) {
        if (!this.cache.has(key)) return -1;
        const entry = this.cache.get(key);
        if (Date.now() > entry.expiry) {
            this.cache.delete(key);
            return -1;
        }
        return entry.value;
    }

    count() {
        let valid = 0;
        for (const [key, entry] of this.cache.entries()) {
            if (Date.now() <= entry.expiry) valid++;
            else this.cache.delete(key);
        }
        return valid;
    }
}
