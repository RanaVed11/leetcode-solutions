class EventEmitter {
    constructor() {
        this.events = {};
    }

    subscribe(event, callback) {
        if (!this.events[event]) {
            this.events[event] = [];
        }
        this.events[event].push(callback);

        return {
            unsubscribe: () => {
                this.events[event] = this.events[event].filter(cb => cb !== callback);
            }
        };
    }

    emit(event, args = []) {
        if (!this.events[event]) return [];
        return this.events[event].map(cb => cb(...args));
    }
}
